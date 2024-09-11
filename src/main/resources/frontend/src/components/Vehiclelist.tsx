import React from 'react';
import { VehicleResponse } from './Types';
import axios from 'axios';
import { useQuery } from '@tanstack/react-query';

interface VehicleListProps {
    // Define the props for your component here
}



const VehicleList: React.FC<VehicleListProps> = (props) => {
    // Implement your component logic here
    const getVehicles = async (): Promise<VehicleResponse[]> => {
        const response = await axios.get("http://localhost:8080/user/vehicles");
        return response.data.vehicles;
    }

    const vehicleQuery = useQuery({
        queryKey: ["vehicles"],
        queryFn: getVehicles
    });
    if (!vehicleQuery.isSuccess) {
        return <span>Loading...</span>
    }
    else if (vehicleQuery.error) {
        return <span>Error when fetching cars...</span>
    }
    else {
        return (
            <table>
                <tbody>
                    {
                        vehicleQuery.data.map((vehicle: VehicleResponse) =>
                            <tr key={vehicle._links.self.href}>
                                <td>{vehicle.brand}</td>
                                <td>{vehicle.model}</td>
                                <td>{vehicle.color}</td>
                                <td>{vehicle.registrationNumber}</td>
                                <td>{vehicle.modelYear}</td>
                                <td>{vehicle.price}</td>
                            </tr>)
                    }
                </tbody>
            </table>
        );
    }
};

export default VehicleList;
//300