import React from "react";
import { Link, useLocation } from "react-router-dom";
import Navbar from "../components/layout/NavBar";
import styles from "./ResultadoPesquisa.module.css";
import { AiOutlineArrowLeft } from "react-icons/ai";
import Card from "../components/cards/Card";
import Footer from "../components/layout/Footer";
import Container from "../components/layout/Container";

function ResultadosPesquisa() {
  const location = useLocation();
  const { results } = location.state || [];

  return (
    <>
      <Navbar />
      <Container>
        <div className={styles.containerResultadoPesquisa}>
          <section className={styles.tituloResultadoContainer}>
            <Link to={"/"}>
              <h1 className={styles.voltarHome}>
                <AiOutlineArrowLeft />
                Voltar
              </h1>
            </Link>
            <h2 className={styles.resultadoBusca}>
              Exibindo resultados para: {location.state.term}{" "}
            </h2>

            <h3 className={styles.resultadoCount}>
              {results.length} livros encontrados
            </h3>
            <div className={styles.linhaHorizontal}/>
          </section>

          {location.state.results.map((livro) => (
          <Card key={livro.idLivro} livro={livro} />
        ))}

          {!results && (
            <p className={styles.semResultado}>Nenhum resultado encontrado.</p>
          )}
        </div>
      </Container>
      <Footer />
    </>
  );
}

export default ResultadosPesquisa;
