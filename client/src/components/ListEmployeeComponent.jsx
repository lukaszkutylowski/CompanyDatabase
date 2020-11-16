import React, { Component } from 'react';
import CompanyService from '../services/CompanyService';

class ListEmployeeComponent extends Component{
    constructor(props) {
        super(props);

        this.state = {
            company : []
        }
    }

    componentDidMount(){
        CompanyService.getSelectPayload().then( res => {
            this.setState({company : res.data});
        });
    }

    render() {
        return(
            <div>
                <h2 className="text-center">Company Database</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <th>Employee First Name</th>
                            <th>Employee Last Name</th>
                            <th>Actions</th>
                        </thead>
                        <tbody>
                            {
                                this.state.company.map(
                                    info => 
                                    <tr key = {info.id}>
                                        <td>{info.firstname}</td>
                                        <td>{info.lastname}</td>
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