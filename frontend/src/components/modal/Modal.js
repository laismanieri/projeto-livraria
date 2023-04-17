import styles from '../modal/Modal.module.css';
import { useState } from 'react';
import ModalCarrinho from './ModalCarrinho';
import { AiOutlineArrowLeft } from "react-icons/ai";

function Modal({ isOpen, onClose, imagem, nome, preco, autor, descricao, editora, genero, anoDePublicacao, precoOferta }) {

    const [modalCarrinhoOpen, setModalCarrinhoOpen] = useState(false);
    const [quantidade, setQuantidade] = useState(1);

    const handleOpenModalCarrinho = () => {
        setModalCarrinhoOpen(true);
    };
    
    const handleCloseModalCarrinho = () => {
        setModalCarrinhoOpen(false);
    };

    const handleIncrementQuantidade = () => {
        setQuantidade(quantidade + 1);
    };

    const handleDecrementQuantidade = () => {
        if (quantidade > 1) {
            setQuantidade(quantidade - 1);
        }
    };

    const handleAddToCart = () => {
        onClose({
          imagem,
          nome,
          preco,
          autor,
          descricao,
          editora,
          genero,
          anoDePublicacao,
          precoOferta,
          quantidade
        });
        setModalCarrinhoOpen(true);
      };
      

    return (
        <>
            {isOpen && (
                <div className={styles.modal}>

                    <div className={styles.container}>
                    <span className={styles.close} onClick={onClose}><AiOutlineArrowLeft/>Voltar</span>
                        <div className={styles.gridContainer}>
                            <div className={styles.gridItemLong}>
                                <img className={styles.imagem} src={imagem} alt={nome}/>
                            </div>
                            <div className={styles.gridItemLong}>
                                <h1 className={styles.titulo} >
                                    {nome}
                                </h1>
                                <p className={styles.autor}>
                                    {autor}
                                </p>
                                <p className={styles.editora}>
                                    {editora}
                                </p>
                                <p className={styles.descricao}>
                                    {descricao}
                                </p>

                            </div>
                            <div className={styles.comprarLivros}>
                                <div className={styles.divComprarLivros}>
                                    <div className={styles.compra}>
                                        <div className={styles.preco}>
                                            <h1 className={styles.preco}>
                                            R$ {preco.toFixed(2)}
                                            </h1>
                                        </div>
                                        <div className={styles.qtde}>
                                            <button onClick={handleDecrementQuantidade} className={styles.buttonQtde}>-</button>
                                                <span className={styles.spanQtde}>{quantidade}</span>
                                            <button onClick={handleIncrementQuantidade} className={styles.buttonQtde}>+</button>
                                        </div>
                                    </div>
                                    <div >
                                        <button className={styles.buttonCompra} onClick={() => { handleAddToCart(); setModalCarrinhoOpen(true); }}>                      
                                            <h1 className={styles.h1AdicionarSacola} >Adicionar à sacola</h1>                 
                                        </button>
                                        <button className={styles.buttonAdicionarSacola} >                      
                                            <h1 className={styles.h1AdicionarSacola} >Comprar</h1>                 
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                <div className={styles.fichaTecnica}>
                        <h1 className={styles.fichaH1}>Ficha Técnica</h1>
                        <div className={styles.ficha}>
                            <ul className={styles.ficha2}>
                                <li className={styles.fichaInfo}>
                                    <span className={styles.fichaTh}>Titulo:</span>
                                    
                                </li>
                                <li>
                                    <span className={styles.fichaTr}>{nome}</span>
                                </li>
                            </ul>
                            <ul className={styles.ficha1}>
                                <li className={styles.fichaInfo}>
                                    <span className={styles.fichaTh}>Autor(a):</span>
                                    
                                </li>
                                <li>
                                    <span className={styles.fichaTr}>{autor}</span>
                                </li>
                            </ul>
                            <ul className={styles.ficha2}>
                                <li className={styles.fichaInfo}>
                                    <span className={styles.fichaTh}>Gênero:</span>
                                    
                                </li>
                                <li>
                                    <span className={styles.fichaTr}>{genero}</span>
                                </li>
                            </ul>
                            <ul className={styles.ficha1}>
                                <li className={styles.fichaInfo}>
                                    <span className={styles.fichaTh}>Editora:</span>
                                    
                                </li>
                                <li>
                                    <span className={styles.fichaTr}>{editora}</span>
                                </li>
                            </ul>
                            <ul className={styles.ficha2}>
                                <li className={styles.fichaInfo}>
                                    <span className={styles.fichaTh}>Ano:</span>
                                    
                                </li>
                                <li>
                                    <span className={styles.fichaTr}>{anoDePublicacao}</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                {modalCarrinhoOpen && (
                <ModalCarrinho
                onClose={() => setModalCarrinhoOpen(false)}
                isOpen={modalCarrinhoOpen}
                imagem={imagem}
                nome={nome}
                preco={parseInt(preco)}
                autor={autor}
                descricao={descricao}
                anoDePublicacao={anoDePublicacao}
                editora={editora}
                genero={genero}
                precoOferta={precoOferta}
                quantidade={quantidade} // passa a quantidade para o componente ModalCarrinho
        />
      )}

            </div>
        )}
      </>
    );
  }
  
export default Modal;
