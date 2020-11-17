import React, { Component } from 'react';
import CompanyService from '../services/CompanyService';

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            employee_id : this.props.match.params.employee_id,
            payload : {}
        }
    }

    componentDidMount() {
        CompanyService.getEmployeeById(this.state.employee_id).then( res => {
            this.setState({payload : res.data});
        });
    }

    render() {
        return (
            <div>
                <div className="card col-md-6 offset-md-3">
                    <h3>View Employee Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label>First Name: &emsp;</label>
                            <div> {this.state.payload.firstname} </div>
                        </div>
                        <div className="row">
                            <label>Last Name: &emsp;</label>
                            <div> {this.state.payload.lastname} </div>
                        </div>
                        <div className="row">
                            <label>Salary: &emsp;</label>
                            <div> {this.state.payload.salary} </div>
                        </div>
                        <div className="row">
                            <label>City: &emsp;</label>
                            <div> {this.state.payload.city} </div>
                        </div>
                        <div className="row">
                            <label>Department: &emsp;</label>
                            <div> {this.state.payload.department} </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEmployeeComponent;