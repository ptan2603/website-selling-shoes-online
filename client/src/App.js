import "./App.css";
import { BrowserRouter as Router } from "react-router-dom";
import UserLayOut from "./layout/UserLayOut";

function App() {
  return (
    <div className="app-component">
      <Router>
        <UserLayOut />
      </Router>
    </div>
  );
}

export default App;
