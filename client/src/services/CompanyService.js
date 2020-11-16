import axios from 'axios';

const COMPANY_API_BASE_URL = 
"http://localhost:8080/api/company";

class CompanyService {

    getAllSelectPayload() {
        return axios.get(
        COMPANY_API_BASE_URL + "/all");
    }

    saveEmployee(payload) {
        return axios.post(
        COMPANY_API_BASE_URL + "/save", payload);
    }

    getEmployeeById(employeeId) {
        return axios.get(
        COMPANY_API_BASE_URL + "/" + employeeId);
    }
}

export default new CompanyService();
