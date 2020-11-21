import React, { Component } from 'react';
import CompanyService from '../services/CompanyService';

class UpdateEmployeeComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            employee_id : this.props.match.params.employee_id,
            firstname : '',
            lastname : '',
            salary : '',
            city : '',
            department : ''
        }

        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeSalaryHandler = this.changeSalaryHandler.bind(this);
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeDepartmentHandler = this.changeDepartmentHandler.bind(this);
        this.updateEmployee = this.updateEmployee.bind(this);
        this.cancel = this.cancel.bind(this);
    }

    componentDidMount() {
        CompanyService.getEmployeeById(this.state.employee_id).then( res => {
            let payload = res.data;
            this.setState(
                {
                    firstname : payload.firstname,
                    lastname : payload.lastname,
                    salary : payload.salary,
                    city : payload.city,
                    department : payload.department
                }
            );
        });
    }

    changeFirstNameHandler = (event) => {
        this.setState({firstname : event.target.value});
    }

    changeLastNameHandler = (event) => {
        this.setState({lastname : event.target.value});
    }

    changeSalaryHandler = (event) => {
        this.setState({salary : event.target.value});
    }

    changeCityHandler = (event) => {
        this.setState({city : event.target.value});
    }

    changeDepartmentHandler = (event) => {
        this.setState({department : event.target.value});
    }

    updateEmployee = (e) => {
        e.preventDefault();
        let payload = {
            firstname : this.state.firstname,
            lastname : this.state.lastname,
            salary : this.state.salary,
            city : this.state.city,
            department : this.state.department
        };
        console.log('payload => ' + JSON.stringify(payload));
        CompanyService.updateEmployee(payload, this.state.employee_id).then( res => {
            this.props.history.push("/");
        });
    }

    cancel() {
        this.props.history.push("/");
    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3">
                            <h3 className="text-center">Update Employee</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>First Name</label>
                                        <input placeholder="First Name"
                                            name="firstname"
                                            className="form-control"
                                            value={this.state.firstname}
                                            onChange={this.changeFirstNameHandler} />           
                                    </div>
                                    <div className="form-group">
                                        <label>Last Name</label>
                                        <input placeholder="Last Name"
                                            name="lastname"
                                            className="form-control"
                                            value={this.state.lastname}
                                            onChange={this.changeLastNameHandler} />           
                                    </div>
                                    <div className="form-group">
                                        <label>Salary</label>
                                        <input placeholder="Salary"
                                            name="salary"
                                            className="form-control"
                                            value={this.state.salary}
                                            onChange={this.changeSalaryHandler} />           
                                    </div>
                                    <div className="form-group">
                                        <label>City</label>
                                        <input placeholder="City"
                                            name="city"
                                            className="form-control"
                                            value={this.state.city}
                                            onChange={this.changeCityHandler} />           
                                    </div>
                                    <div className="form-group">
                                        <label>Department</label>
                                        <input placeholder="Department"
                                            name="department"
                                            className="form-control"
                                            value={this.state.department}
                                            onChange={this.changeDepartmentHandler} />           
                                    </div>
                                    <button className="btn btn-success" onClick={this.updateEmployee}>Update</button>
                                    <button className="btn btn-danger" onClick={this.cancel}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default UpdateEmployeeComponent;