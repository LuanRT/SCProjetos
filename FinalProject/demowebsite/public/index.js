'use strict';

async function start() {
  const list = document.getElementById('list');

  // Temporário! A pagina sera populada dinamicamente, somente para testes de design
  const empregos = [
     `<div class="job" id="job">
        <h2 class="job-title">Software Engineer</h2>
        <div class="job-desc">
          <li> Crie planos e casos de teste detalhados, abrangentes e bem estruturados. Realizar o ciclo completo de testes estimando, priorizando, planejando e coordenando as atividades dos testes, dentro dos prazos estabelecidos.</li><li> Requisitos técnicos obrigatórios: Selênio (experiência em testes) Java, SQL. Inglês avançado Requisito desejável: Jira / ALM / TestRail. Serviços RESTful, SOAP e JSON.</li>
        </div>
        <div class="metadata">
         <p class="info"><b>— Informações —</b></p>
         <p class="mt"><b>Faixa salarial:</b> De R$ 1.001,00 a R$ 2.000,00</p>
         <p class="mt"><b>Anunciante:</b> DIGITAL REPUBLIC</p>
         <p class="mt"><b>Contratante:</b> DIGITAL REPUBLIC</p>
       </div>   
      </div>`,
      `<div class="job" id="job">
        <h2 class="job-title">Backend Software Engineer - Node Js</h2>
        <div class="job-desc">
        Posição para atuar em um projeto de alta visibilidade no maior Banco de investimentos da Amélica Latina.
        
        Um time que está protagonizando desafios relevantes no Banco de investimentos que mais cresce no Brasil.
        
        Equipe de alto nível técnico e atuando com tecnologias modernas.
        
        Uma oportunidade única de aplicar seus conhecimentos com alta exposição ao mercado e impacto direto em um negócio de escala global.
        </div>
       <div class="metadata">
         <p class="info"><b>— Informações —</b></p>
         <p class="mt"><b>Faixa salarial:</b> De R$ 1.001,00 a R$ 2.000,00</p>
         <p class="mt"><b>Anunciante:</b> DIGITAL REPUBLIC</p>
         <p class="mt"><b>Contratante:</b> DIGITAL REPUBLIC</p>
       </div>   
       </div>`,
      `<div class="job" id="job">
        <h2 class="job-title">Administrador De Database</h2>
        <div class="job-desc">
        <li> Participar do design e implementação de APIs tanto para APIs internas quanto para aquelas expostas aos integradores terceirizados; No lado técnico, trabalhar em vários projetos diferentes que abrangem tecnologias, sistemas e processos. Algumas das tecnologias incluem: Go, Javascript / Typescript, Elixir / Erlang, NodeJS, AWS, Kubernetes e Docker. Fornecer documentação e testes cuidadosos e abrangentes para seus recursos antes de enviá-los; Projetar, implementar e melhorar, interativamente, novos serviços e sistemas; Colaborar com outros(as) engenheiros(as) de software, QA e DevOps para garantir uma implantação tranquila, com operação contínua e suporte para software de qualidade; Treinar e orientar outros(as) engenheiros(as) para aumentar suas habilidades e produtividade; Fornecer, ativamente, feedbacks de revisão de código a outros(as) engenheiros(as) de software, levando em consideração tanto o estilo quanto a implementação; Interagir diariamente com diferentes áreas a fim de trazer perspectiva técnica para cada nova funcionalidade, bem como, seu valor agregado ao negócio.</li><li> Vivência em desenvolvimento de software em algumas das seguintes linguagens: GoLang, Javascript / Typescript (React), Ruby, Java / Scala, Python, Erlang / Elixir; Versionamento de códigos e banco de dados; Estar familiarizado(a) com as metodologias ágeis(Scrum ou Kanban). Ter flexibilidade e disposição para lidar com desafios e trazer soluções criativas. </li>
        </div>
        <div class="metadata">
         <p class="info"><b>— Informações —</b></p>
         <p class="mt"><b>Faixa salarial:</b> De R$ 1.001,00 a R$ 2.000,00</p>
         <p class="mt"><b>Anunciante:</b> DIGITAL REPUBLIC</p>
         <p class="mt"><b>Contratante:</b> DIGITAL REPUBLIC</p>
       </div>   
       </div>`
  ]

  // Codigo somente para testes— temporario! Usaremos WebSocket para popular a pagina dinamicamente
  list.innerHTML += empregos.join('');
}

start();