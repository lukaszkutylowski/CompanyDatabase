import axios from 'axios';

const COMPANY_API_BASE_URL = 
"http://localhost:8080/api/company";

class CompanyService {

    getSelectPayload() {
        return axios.get(
        COMPANY_API_BASE_URL + "/all");
    }
}

export default new CompanyService();
