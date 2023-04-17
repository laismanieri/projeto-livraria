import React from "react";
import styles from "../cards/Card.module.css";
import { Link } from "react-router-dom";

function Card({ livro }) {


  return (
    <div className={styles.containerCard}>
      <div className={styles.card}>
        <div className={styles.containerCardImage}>
        <Link to={{ pathname: `/informacao-livro/${livro.idLivro}`, state: { idLivro: livro.idLivro } }}>
            <img
              src={livro.imagem}  
              alt={livro.titulo}
              className={styles.cardImageLivro}

            />
          </Link>
        </div>
        <div className={styles.cardTitulo}>
          <h2>{livro.nome}</h2>
        </div>
        <div className={styles.divPreco}>
          <h1>
            {livro.preco.toLocaleString("pt-BR", {
              style: "currency",
              currency: "BRL",
            })}
          </h1>
        </div>
      </div>
    </div>
  );
}

export default Card;
