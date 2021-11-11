import { Component } from "react";
import React from  'react';
import api from "../api";

class Index extends Component {
    state = {
      contatos: [],
    };
  
    async componentDidMount() {
      const responseContatos = await api.get("/contatos");
      this.setState({ contatos: responseContatos.data });
    }
  
    render() {
      const { contatos } = this.state;
      return (
        <div className="index">
            <div className="contatos-findall">
                {console.log(contatos)}
                {contatos.map((contatos) => (
                <div key={contatos.id}>
                    <p>
                    <span>ID: </span>
                    {contatos.id}
                    </p>
                    <p>
                    <span>Nome: </span>
                    {contatos.nome}
                    </p>
                    <p>
                    <span>Telefone: </span>
                    {contatos.telefone}
                    </p>
                    <p>
                    <span>Email: </span>
                    {contatos.email}
                    </p>
                </div>
                ))}
            </div>
        </div>
      );
    }
}
export default Index;