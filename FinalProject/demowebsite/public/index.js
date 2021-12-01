'use strict';

async function start() {
  const list = document.getElementById('list');

  // Codigo somente para testes— temporario! Usaremos WebSocket para popular a pagina dinamicamente
  for (let i = 0; i < 100; i++) {
    const html =
    `<div class="job" id="job">
        <h2 class="job-title">Titulo da vaga</h2>
        <p class="job-desc">Descrição aqui...</p>
      </div>`;
    list.innerHTML += html;
  }
}

start();