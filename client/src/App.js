import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import ViewEmployeeComponent from './components/ViewEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';

import {
  BrowserRouter as Router,
  Route,
  Switch
} from 'react-router-dom';

function App() {
  return (
    <div>
      <Router>
        <div className="container">
        <Switch>
          <Route path="/" exact component={ListEmployeeComponent}/>
          <Route path="/save" component={CreateEmployeeComponent}/>
          <Route path="/view/:employee_id" component={ViewEmployeeComponent}/>
          <Route path="/update/:employee_id" component={UpdateEmployeeComponent}/>
        </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;
