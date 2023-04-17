    import { useEffect, useState } from "react";
    import axios from "axios";
    import { useParams } from "react-router-dom";
    import styles from "./InformacaoLivro.module.css";
    import { AiOutlineArrowLeft } from "react-icons/ai";
    import Container from "../components/layout/Container";
    import Navbar from "../components/layout/NavBar";
    import Footer from "../components/layout/Footer";


    function InformacaoLivro(props) {
    const { idLivro } = useParams();
    const [livro, setLivro] = useState(null);
    const [quantidade, setQuantidade] = useState(1);

    useEffect(() => {
        axios
        .get(`http://localhost:8082/livro/${idLivro}`)
        .then((response) => {
            setLivro(response.data);
        })
        .catch((error) => {
            console.error(error);
        });
    }, [idLivro]);

    if (!livro) {
        return <p>Carregando...</p>;
    }

    const handleIncrementQuantidade = () => {
        setQuantidade(quantidade + 1);
    };

    const handleDecrementQuantidade = () => {
        if (quantidade > 1) {
        setQuantidade(quantidade - 1);
        }
    };

    return (
        <>
        <Navbar/>
        <Container>
        <div className={styles.container}>
        <span className={styles.close}>
            <AiOutlineArrowLeft />
            Voltar
        </span>
        <div className={styles.gridContainer}>
            <div className={styles.gridItemLong}>
            <img className={styles.imagemLivro} src={livro.imagem} alt={livro.nome} />
            </div>
            <div className={styles.gridItemLong}>
            <h1 className={styles.titulo}>{livro.nome}</h1>
            <p className={styles.autor}>{livro.autor}</p>
            <p className={styles.editora}>{livro.editora}</p>
            <p className={styles.descricao}>{livro.descricao}</p>
            </div>
            <div className={styles.comprarLivros}>
            <div className={styles.divComprarLivros}>
                <div className={styles.compra}>
                <div className={styles.preco}>
                    <h1 className={styles.preco}>R$ {livro.preco.toFixed(2)}</h1>
                </div>
                <div className={styles.qtde}>
                    <button
                    onClick={handleDecrementQuantidade}
                    className={styles.buttonQtde}
                    >
                    -
                    </button>
                    <span className={styles.spanQtde}>{livro.quantidade}</span>
                    <button
                    onClick={handleIncrementQuantidade}
                    className={styles.buttonQtde}
                    >
                    +
                    </button>
                </div>
                </div>
                <div>
                <button className={styles.buttonCompra}>
                    <h1 className={styles.h1AdicionarSacola}>Adicionar à sacola</h1>
                </button>
                <button className={styles.buttonAdicionarSacola}>
                    <h1 className={styles.h1AdicionarSacola}>Comprar</h1>
                </button>
                </div>
            </div>
            </div>
        </div>
        <div className={styles.linhaHorizontal} />
        <div className={styles.fichaTecnica}>
            <h1 className={styles.fichaH1}>Ficha Técnica</h1>
            <div className={styles.ficha}>
            <ul className={styles.ficha2}>
                <li className={styles.fichaInfo}>
                <span className={styles.fichaTh}>Titulo:</span>
                </li>
                <li>
                <span className={styles.fichaTr}>{livro.nome}</span>
                </li>
            </ul>
            <ul className={styles.ficha1}>
                <li className={styles.fichaInfo}>
                <span className={styles.fichaTh}>Autor(a):</span>
                </li>
                <li>
                <span className={styles.fichaTr}>{livro.autor}</span>
                </li>
            </ul>
            <ul className={styles.ficha2}>
                <li className={styles.fichaInfo}>
                <span className={styles.fichaTh}>Gênero:</span>
                </li>
                <li>
                <span className={styles.fichaTr}>{livro.genero}</span>
                </li>
            </ul>
            <ul className={styles.ficha1}>
                <li className={styles.fichaInfo}>
                <span className={styles.fichaTh}>Editora:</span>
                </li>
                <li>
                <span className={styles.fichaTr}>{livro.editora}</span>
                </li>
            </ul>
            <ul className={styles.ficha2}>
                <li className={styles.fichaInfo}>
                <span className={styles.fichaTh}>Ano:</span>
                </li>
                <li>
                <span className={styles.fichaTr}>{livro.anoDePublicacao}</span>
                </li>
            </ul>
            </div>
        </div>
        </div>
        </Container>
        <Footer/>
        </>
    );
    }

    export default InformacaoLivro;
