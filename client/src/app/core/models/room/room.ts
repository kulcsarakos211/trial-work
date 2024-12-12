import { User } from "../user/user";

export class Room {
    id: number;
    owner: User;
    name: string;

    constructor() {
        this.id = 0;
        this.owner = new User();
        this.name = "";
    }
}
