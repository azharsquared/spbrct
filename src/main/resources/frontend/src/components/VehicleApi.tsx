import { Vehicle } from './Types';
import { VehicleResponse } from './Types';
import axios from 'axios';

export const getVehicles = async (): Promise<VehicleResponse[]> => {
    const response = await axios.get(`${import.meta.env.VITE_API_URL}/user/vehicles`);
    console.log(response.data);
    return response.data;
}

export const deleteVehicle = async (id: string): Promise<VehicleResponse> =>
    {
     const response = await axios.delete(`${import.meta.env.VITE_API_URL}/user/vehicle/${id}`);
     return response.data
    }


    // Add a new car
export const addVehicle = async (vehicle: Vehicle): Promise<VehicleResponse> => {
    const response = await axios.post(`${import.meta.env.VITE_API_URL}/user/vehicle`, vehicle, {
    headers: {
    'Content-Type': 'application/json',
    }, 
    });
    
    return response.data;
   }