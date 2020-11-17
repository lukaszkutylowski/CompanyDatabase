import React, { Component } from 'react';
import CompanyService from '../services/CompanyService';

class ListEmployeeComponent extends Component{
    constructor(props) {
        super(props);

        this.state = {
            payload : []
        }

        this.addEmployee = this.addEmployee.bind(this);
    }

    componentDidMount(){
        CompanyService.getAllSelectPayload().then( res => {
            this.setState({payload : res.data});
        });
    }

    addEmployee() {
        this.props.history.push("/save");
    }

    viewEmployee(id) {
        this.props.history.push("/view/" + id);
    }

    render() {
        return(
            <div>
                <h2 className="text-center">Company Database</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addEmployee}>Add Employee</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <th>Employee First Name</th>
                            <th>Employee Last Name</th>
                            <th>Actions</th>
                        </thead>
                        <tbody>
                            {
                                this.state.payload.map(
                                    info => 
                                    <tr key = {info.employee_id}>
                                        <td>{info.firstname}</td>
                                        <td>{info.lastname}</td>
                                        <td>
                                            <button style={{marginLetf: "10px"}} onClick={ () => this.viewEmployee(info.employee_id)} className="btn btn-info">View</button>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListEmployeeComponent;