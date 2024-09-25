export type VehicleResponse = {
    brand: string;
    model: string;
    color: string;
    registrationNumber: string;
    modelYear: number;
    price: number;
    id: string;
    // _links: {
    //     self: {
    //         href: string;
    //     },
    //     car: {
    //         href: string;
    //     },
    //     owner: {
    //         href: string;
    //     }
    // };
};

export type Vehicle = {
    brand: string;
    model: string;
    color: string;
    registrationNumber: string;
    modelYear: number;
    price: number;
    description: string;
}

export type VehicleEntry = {
    vehicle: Vehicle;
    id: string;
   }