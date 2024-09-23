export type VehicleResponse = {
    brand: string;
    model: string;
    color: string;
    registrationNumber: string;
    modelYear: number;
    price: number;
    _links: {
        self: {
            href: string;
        },
        car: {
            href: string;
        },
        owner: {
            href: string;
        }
    };
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