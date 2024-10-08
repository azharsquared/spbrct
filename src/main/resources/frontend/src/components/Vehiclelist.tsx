import React, { useState } from 'react';
import { VehicleResponse } from './Types';
import axios from 'axios';
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import { getVehicles, deleteVehicle } from './VehicleApi';
import { DataGrid, GridCellParams, GridColDef ,GridToolbar} from '@mui/x-data-grid';
import Snackbar from '@mui/material/Snackbar';
import AddVehicle from './AddVehicle';
import EditVehicle from './EditVehicle';
import IconButton from '@mui/material/IconButton';
import DeleteIcon from '@mui/icons-material/Delete';

interface VehicleListProps {
    // Define the props for your component here
}






const VehicleList: React.FC<VehicleListProps> = (props) => {
    const [open, setOpen] = useState(false);
    const queryClient = useQueryClient()


    const columns: GridColDef[] = [
        { field: 'brand', headerName: 'Brand', width: 200 },
        { field: 'model', headerName: 'Model', width: 200 },
        { field: 'color', headerName: 'Color', width: 200 },
        { field: 'registrationNumber', headerName: 'Reg.nr.', width: 150 },
        { field: 'modelYear', headerName: 'Model Year', width: 150 },
        { field: 'price', headerName: 'Price', width: 150 }
        ,
        {
            field: 'edit',
            headerName: '',
            width: 90,
            sortable: false,
            filterable: false,
            disableColumnMenu: true,
            renderCell: (params: GridCellParams) =>
                <EditVehicle vehicledata={params.row} />
        },
        {
            field: 'delete',
            headerName: '',
            width: 90,
            sortable: false,
            filterable: false,
            disableColumnMenu: true,
            renderCell: (params: GridCellParams) => (
                <IconButton aria-label="delete" size="small"
                    onClick={() => {
                        if (window.confirm(`Are you sure you want to delete ${params.row.
                            brand} ${params.row.model}?`)) {
                            mutate(params.id.toString());
                        }
                    }

                    }
                >
                    <DeleteIcon fontSize="small" />
                </IconButton>
            ),
        }
    ];

    const { mutate } = useMutation(deleteVehicle, {
        onSuccess: () => {
            console.log("Vehicle deleted successfully");
            setOpen(true);
            queryClient.invalidateQueries({ queryKey: ['vehicles'] });

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
            <>
                <AddVehicle />
                <DataGrid
                    disableRowSelectionOnClick={true}
                    rows={vehicleQuery.data}
                    columns={columns}
                    getRowId={row => row.id}
                    slots={{ toolbar: GridToolbar }}
                />

                <Snackbar
                    open={open}
                    autoHideDuration={2000}
                    onClose={() => setOpen(false)}
                    message="Car deleted" />
            </>
        );
    }
};

export default VehicleList;
//300