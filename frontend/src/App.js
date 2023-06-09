import { Route, Routes, BrowserRouter } from "react-router-dom";
import Home from './pages/Home';
import ResultadosPesquisa from "./pages/ResultadosPesquisa";
import Login from "./pages/Login";
import Cadastro from "./pages/Cadastro";
import Contact from "./pages/Contact"
import InformacaoLivro from "./pages/InformacaoLivro";


function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route element={<Home />} path="/" exact></Route>
          <Route element={<Login />} path="/login" />
          <Route element={<Cadastro />} path="/cadastro" />
          <Route element={<ResultadosPesquisa />} path="/resultados-pesquisa"></Route>
          <Route element={<Contact />} path="/contact" />
          <Route element={<InformacaoLivro />} path="/informacao-livro/:idLivro" />

        </Routes>
      </BrowserRouter>  
    </div>
  );
}

export default App;
