import DialogContent from '@mui/material/DialogContent';
import { Vehicle } from './Types';
import Stack from '@mui/material/Stack';
import { TextField } from '@mui/material';
type DialogFormProps = {
   vehicle: Vehicle;
   handleChange: (event: React.ChangeEvent<HTMLInputElement>) =>
      void;
}
function VehicleDialogContent({ vehicle, handleChange }: DialogFormProps) {
   return (
      <DialogContent>
         <Stack spacing={2} mt={1}>
            <TextField placeholder="Brand" name="brand"
               value={vehicle.brand} onChange={handleChange} />
            <TextField placeholder="Model" name="model"
               value={vehicle.model} onChange={handleChange} /> 
            <TextField placeholder="Color" name="color"
               value={vehicle.color} onChange={handleChange} />
            <TextField placeholder="Year" name="modelYear"
               value={vehicle.modelYear} onChange={handleChange} /> 
            <TextField placeholder="Reg.nr." name="registrationNumber"
               value={vehicle.registrationNumber} onChange={handleChange} /> 
            <TextField placeholder="Price" name="price"
               value={vehicle.price} onChange={handleChange} /> 
         </Stack>
      </DialogContent>
   );
}
export default VehicleDialogContent;