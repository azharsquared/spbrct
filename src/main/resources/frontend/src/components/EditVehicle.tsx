import { useState } from 'react';
import { Vehicle, VehicleResponse } from './Types';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogTitle from '@mui/material/DialogTitle';
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


    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleSave = () => {
        setOpen(false);
    }
    return (
        <>
            <button onClick={handleClickOpen}>
                Edit
            </button>
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Edit</DialogTitle>
                <DialogActions>
                    <button onClick={handleClose}>Cancel</button>
                    <button onClick={handleSave}>Save</button>
                </DialogActions>
            </Dialog>
        </>
    );

}


export default EditVehicle;
