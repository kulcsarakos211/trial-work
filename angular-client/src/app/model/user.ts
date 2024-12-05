export class User {
    id: string;
    name: string;
    email: string;
    password: string;
    firstLogin: boolean;

    constructor() {
        this.id = "";
        this.name = "";
        this.email = "";
        this.password = "";
        this.firstLogin = false;
    }
}
