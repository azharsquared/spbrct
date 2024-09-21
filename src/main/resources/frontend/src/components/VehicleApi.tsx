import { VehicleResponse } from './Types';
import axios from 'axios';

export const getVehicles = async (): Promise<VehicleResponse[]> => {
    const response = await axios.get(`${import.meta.env.VITE_API_URL}/user/vehicles`);
    console.log(response.data);
    return response.data;
}