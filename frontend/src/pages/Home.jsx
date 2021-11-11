import React from  'react';
import {Link} from "react-router-dom";

function Home(){
    return(
        <>
            <section className="botoes-menu">
                <ul>
                    <li>
                        <Link to="/index">
                            <button id="botao-index" type="button" className="botoes-menu">INDEX</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/show">
                            <button id="botao-show" type="button" className="botoes-menu">SHOW</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/create">
                            <button id="botao-create" type="button" className="botoes-menu">CREATE</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/contatos/delete">
                            <button id="botao-delete" type="button" className="botoes-menu">DELETE</button>
                        </Link>
                    </li>
                    <li>    
                        <Link to="/contatos/update">
                            <button id="botao-update" type="button" className="botoes-menu">UPDATE</button>
                        </Link>
                    </li>                    
                </ul>
            </section>
        </>
    );
}
export default Home;