import './App.css';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';

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
          {/* <Route path="" component={}/> */}
        </Switch>
        </div>
      </Router>
    </div>
  );
}

export default App;
