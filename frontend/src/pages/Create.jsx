import React, { useState } from 'react';
import api from "../api";

function Create(){

    const [contatoNome, setNome] = useState("");
    const [contatoTelefone, setTelefone] = useState("");
    const [contatoEmail, setEmail] = useState("");

    const handleSubmit = (e) =>{
        e.preventDefault();
        const criarContatos = {
            nome: contatoNome,
            telefone: contatoTelefone,
            email: contatoEmail
        }
        api.post('/contatos', criarContatos).then((resp) => {
            console.log(resp);
        });
    }
    return(
        <>
            <form className="criaContato-form" onSubmit={handleSubmit}>
                {/* <Link to="/">
                    <button type="button" className="btn-back">Back</button>
                </Link> */}
                <ul>
                    <li>
                        <input name="nome-input" onChange={value => setNome(value.target.value)} value={contatoNome} className="criaContato-input" type="text" placeholder="Nome"></input>
                    </li>
                    <li>
                        <input name="telefone-input" onChange={value => setTelefone(value.target.value)} value={contatoTelefone} className="criaContato-input" type="text" placeholder="Telefone"></input>
                    </li>
                    <li>
                        <input name="email-input" onChange={value => setEmail(value.target.value)} value={contatoEmail} className="criaContato-input" type="text" placeholder="Email"></input>
                    </li>
                    <li>
                        <button name="criaContato-submit" type="submit" className="criaContato-input">Submit</button>
                    </li>
                </ul>
            </form>
        </>
    );
}
export default Create;