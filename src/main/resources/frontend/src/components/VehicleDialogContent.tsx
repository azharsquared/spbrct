import DialogContent from '@mui/material/DialogContent';
import { Vehicle } from './Types';
type DialogFormProps = {
 vehicle: Vehicle;
 handleChange: (event: React.ChangeEvent<HTMLInputElement>) =>
 void;
}
function VehicleDialogContent({ vehicle, handleChange }: DialogFormProps) {
 return (
    <DialogContent>
    <input placeholder="Brand" name="brand"
    value={vehicle.brand} onChange={handleChange}/><br/>
    <input placeholder="Model" name="model"
    value={vehicle.model} onChange={handleChange}/><br/>
    <input placeholder="Color" name="color"
    value={vehicle.color} onChange={handleChange}/><br/>
    <input placeholder="Year" name="modelYear"
    value={vehicle.modelYear} onChange={handleChange}/><br/>
    <input placeholder="Reg.nr." name="registrationNumber"
    value={vehicle.registrationNumber} onChange={handleChange}/><br/>
    <input placeholder="Price" name="price"
    value={vehicle.price} onChange={handleChange}/><br/>
    </DialogContent>
 );
}
export default VehicleDialogContent;