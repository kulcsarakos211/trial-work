import { HttpHeaders } from "@angular/common/http";

export const Globals = Object.freeze({
    SERVICE_HEADERS: new HttpHeaders({'X-Api-Key': 'app'})
});