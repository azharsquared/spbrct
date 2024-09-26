import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { useMutation, useQueryClient } from '@tanstack/react-query';
import React, { useState } from 'react';
import { addVehicle } from './VehicleApi';
import { Vehicle } from './Types';
import VehicleDialogContent from './VehicleDialogContent';



const AddVehicle: React.FC = () => {

    const queryClient = useQueryClient();

    const { mutate } = useMutation(addVehicle, {
        onSuccess: () => {
        queryClient.invalidateQueries(["vehicles"]);
        },
        onError: (err) => {
        console.error(err);
        },
       });

    const [open, setOpen] = useState(false);
    const [vehicle, setVehicle] = useState<Vehicle>({
        brand: '',
        model: '',
        color: '',
        registrationNumber: '',
        modelYear: 0,
        price: 0,
        description: '',
    });

    const handleClickOpen = () => {
        setOpen(true);
    };

    // Close the modal form
    const handleClose = () => {
        setOpen(false);
    }

    const handleChange = (event : React.ChangeEvent<HTMLInputElement>) =>
        {
         setVehicle({...vehicle, [event.target.name]:
         event.target.value});
        }

        const handleSave = () => {
            mutate(vehicle); 
            setVehicle({ brand: '', model: '', color: '', registrationNumber:'',
            modelYear: 0, price: 0 , description: ''});
            handleClose();
           }
           

    return (
        <>
            <Button onClick={handleClickOpen}>New vehicle</Button>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>New vehicle</DialogTitle>
                {/* <DialogContent>
                    <input placeholder="Brand" name="brand"
                        value={vehicle.brand} onChange={handleChange} /><br />
                    <input placeholder="Model" name="model"
                        value={vehicle.model} onChange={handleChange} /><br />
                    <input placeholder="Color" name="color"
                        value={vehicle.color} onChange={handleChange} /><br />
                    <input placeholder="Year" name="modelYear"
                        value={vehicle.modelYear} onChange={handleChange} /><br />
                    <input placeholder="Reg.nr" name="registrationNumber"
                        value={vehicle.registrationNumber} onChange={handleChange} /><br />
                    <input placeholder="Price" name="price"
                        value={vehicle.price} onChange={handleChange} /><br />
                        <input placeholder="Description" name="description"
                        value={vehicle.description} onChange={handleChange} /><br />
                </DialogContent> */}
                <VehicleDialogContent vehicle={vehicle} handleChange={handleChange} />
                <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button onClick={handleSave}>Save</Button>
                </DialogActions>
            </Dialog>
        </>
    );
};

export default AddVehicle;