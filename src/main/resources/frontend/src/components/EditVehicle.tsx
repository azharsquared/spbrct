import { useState } from 'react';
import { Vehicle, VehicleResponse , VehicleEntry} from './Types';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogTitle from '@mui/material/DialogTitle';
import VehicleDialogContent from './VehicleDialogContent';
import { updateVehicle } from './VehicleApi';
import { useMutation, useQueryClient } from '@tanstack/react-query';

type FormProps = {
    vehicledata: VehicleResponse;
}
function EditVehicle({ vehicledata }: FormProps) {
    const [open, setOpen] = useState(false);
    const [vehicle, setVehicle] = useState<Vehicle>({
        brand: '',
        model: '',
        color: '',
        registrationNumber: '',
        modelYear: 0,
        price: 0,
        description: ''
    });

    const queryClient = useQueryClient();
    // Use useMutation hook
    const { mutate } = useMutation(updateVehicle, {
        onSuccess: () => {
            queryClient.invalidateQueries(["vehicles"]);
        },
        onError: (err) => {
            console.error(err);
        }
    });


    const handleClickOpen = () => {
        setVehicle({
            brand: vehicle.brand,
            model: vehicle.model,
            color: vehicle.color,
            registrationNumber: vehicle.registrationNumber,
            modelYear: vehicle.modelYear,
            price: vehicle.price,
            description: vehicle.description
        });
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleSave = () => {
        const id = vehicledata.id;
        const carEntry: VehicleEntry = {vehicle, id}
        mutate(carEntry);
        setVehicle({ brand: '', model: '', color: '', registrationNumber:'',
        modelYear: 0, price: 0 , description: ''});
        setOpen(false)
    }

    const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        setVehicle({ ...vehicle, [event.target.name]: event.target.value });
    }
    return (
        <>
            <button onClick={handleClickOpen}>
                Edit
            </button>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Edit</DialogTitle>
                <VehicleDialogContent vehicle={vehicle} handleChange={handleChange} />
                <DialogActions>
                    <button onClick={handleClose}>Cancel</button>
                    <button onClick={handleSave}>Save</button>
                </DialogActions>
            </Dialog>
        </>
    );

}


export default EditVehicle;
