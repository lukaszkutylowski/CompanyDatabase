import React, { Component } from 'react';
import CompanyService from '../services/CompanyService';

class ListEmployeeComponent extends Component{
    constructor(props) {
        super(props);

        this.state = {
            all : []
        }

        this.addEmployee = this.addEmployee.bind(this);
        this.viewEmployee = this.viewEmployee.bind(this);
        this.editEmployee = this.editEmployee.bind(this);
        this.deleteEmployee = this.deleteEmployee.bind(this);
    }

    componentDidMount(){
        CompanyService.getAllSelectPayload().then( res => {
            this.setState({all : res.data});
        });
    }

    addEmployee() {
        this.props.history.push("/save");
    }

    viewEmployee(id) {
        this.props.history.push("/view/" + id);
    }

    editEmployee(id) {
        this.props.history.push("/update/" + id);
    }

    deleteEmployee(id) {
        CompanyService.deleteEmployee(id).then( res => {
            this.setState({info : this.state.all.filter(info => info.employee_id != id)});
            this.relaod();
        });
    }

    relaod() {
        window.location.reload(false);
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
                                this.state.all.map(
                                    info => 
                                    <tr key = {info.employee_id}>
                                        <td>{info.firstname}</td>
                                        <td>{info.lastname}</td>
                                        <td>
                                            <button style={{marginRight: "10px"}} onClick={ () => this.viewEmployee(info.employee_id)} className="btn btn-info">View</button>
                                            <button style={{marginRight: "10px"}} onClick = { () => this.editEmployee(info.employee_id)} className="btn btn-info">Update</button>
                                            <button onClick = { () => this.deleteEmployee(info.employee_id)} className="btn btn-danger">Delete</button>
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