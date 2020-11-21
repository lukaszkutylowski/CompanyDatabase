import axios from 'axios';

const COMPANY_API_BASE_URL = 
"http://localhost:8080/api/company";

class CompanyService {

    getAllSelectPayload() {
        return axios.get(
        COMPANY_API_BASE_URL + '/all');
    }

    saveEmployee(payload) {
        return axios.post(
        COMPANY_API_BASE_URL + '/save', payload);
    }

    getEmployeeById(employee_id) {
        return axios.get(
        COMPANY_API_BASE_URL + '/get/' + employee_id);
    }

    updateEmployee(payload, employee_id) {
        return axios.put(
        COMPANY_API_BASE_URL + '/update/' + employee_id, payload
        );
    }

    deleteEmployee(employee_id) {
        return axios.delete(
        COMPANY_API_BASE_URL + '/delete/' + employee_id
        );
    }
}

export default new CompanyService();
