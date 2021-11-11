import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Home from './pages/Home';
import Index from './pages/Index';
// import Show from './pages/Show';
import Create from './pages/Create';
import Update from './pages/Update';
import Delete from './pages/Delete';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/index" component={Index} />
        {/* <Route path="/show" component={Show} /> */}
        <Route path="/create" component={Create} />
        <Route path="/contatos/update" component={Update} />
        <Route path="/contatos/delete" component={Delete} />
      </Switch>
    </Router>
  );
}

export default App;
