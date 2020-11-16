import React, { Component } from 'react';
import CompanyService from '../services/CompanyService';

class CreateEmployeeComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
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
        this.saveEmployee = this.saveEmployee.bind(this);
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

    saveEmployee = (e) => {
        e.preventDefault();
        let payload = {
            firstname : this.state.firstname,
            lastname : this.state.lastname,
            salary : this.state.salary,
            city : this.state.city,
            department : this.state.department
        }; 
        console.log('payload => ' + JSON.stringify(payload));
        CompanyService.saveEmployee(payload).then( res => {
            this.props.history.push("/");
        });
    }

    render() {
        return(
            <div>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add Employee</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>First Name:</label>
                                        <input placeholder="First Name" name="firstname" className="form-control"
                                            value={this.state.firstname} onChange={this.changeFirstNameHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label>Last Name:</label>
                                        <input placeholder="Last Name" name="lastname" className="form-control"
                                            value={this.state.lastname} onChange={this.changeLastNameHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label>Salary:</label>
                                        <input placeholder="Salary" name="salary" className="form-control"
                                            value={this.state.salary} onChange={this.changeSalaryHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label>City:</label>
                                        <input placeholder="City" name="city" className="form-control"
                                            value={this.state.city} onChange={this.changeCityHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label>Department:</label>
                                        <input placeholder="Department" name="department" className="form-control"
                                            value={this.state.department} onChange={this.changeDepartmentHandler} />
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveEmployee}>Save</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default CreateEmployeeComponent;