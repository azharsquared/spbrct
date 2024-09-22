import React from 'react';
import { VehicleResponse } from './Types';
import axios from 'axios';
import { useMutation, useQuery } from '@tanstack/react-query';
import { getVehicles,deleteVehicle } from './VehicleApi';
import { DataGrid,GridCellParams,GridColDef } from '@mui/x-data-grid';

interface VehicleListProps {
    // Define the props for your component here
}


   



const VehicleList: React.FC<VehicleListProps> = (props) => {
    // Implement your component logic here

    const columns: GridColDef[] = [
        {field: 'brand', headerName: 'Brand', width: 200},
        {field: 'model', headerName: 'Model', width: 200},
        {field: 'color', headerName: 'Color', width: 200},
        {field: 'registrationNumber', headerName: 'Reg.nr.', width: 150},
        {field: 'modelYear', headerName: 'Model Year', width: 150},
        {field: 'price', headerName: 'Price', width: 150},
        {
            field: 'delete',
            headerName: '',
            width: 90,
            sortable: false,
            filterable: false,
            disableColumnMenu: true,
            renderCell: (params: GridCellParams) => (
            <button
            onClick={() => mutate(params.id.toString())}
            >
            Delete
            </button>
            ),
            },
       ];

    const { mutate } = useMutation(deleteVehicle, {
        onSuccess: () => {
        console.log("Vehicle deleted successfully");
        },
        onError: (err) => {
        console.error(err);
        },
       });


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
            // <table>
            //     <tbody>
            //         {
            //             vehicleQuery.data.map((vehicle: VehicleResponse) =>
            //                 <tr >
            //                     <td>{vehicle.brand}</td>
            //                     <td>{vehicle.model}</td>
            //                     <td>{vehicle.color}</td>
            //                     <td>{vehicle.registrationNumber}</td>
            //                     <td>{vehicle.modelYear}</td>
            //                     <td>{vehicle.price}</td>
            //                 </tr>)
            //         }
            //     </tbody>
            // </table>
            <DataGrid
            rows={vehicleQuery.data}
            columns={columns}
            getRowId={row => row.id}
            />
        );
    }
};

export default VehicleList;
//300