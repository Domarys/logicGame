# logicGame
Resumo. Este artigo vai detalhar o protocolo da camada de Aplicação que será implementado no jogo Logic Game, como parte de um trabalho da disciplina de Redes de Computadores. Nele serão apresentadas informações iniciais que poderão sofrer algumas alterações no momento  da implementação visando uma melhor adaptação aos conceitos vistos na disciplina que devem ser aplicados. 
1. Introdução
Este trabalho irá definir e detalhar as especificações iniciais (protocolos, mensagens, máquinas de estados finitos e outras informações) de um jogo que também será implementado para a Disciplina de Redes de Computadores do curso de Bacharel de Ciência da Computação da Universidade Federal de Pelotas. 
	Primeiramente vamos descrever o jogo e seu funcionamento básico para melhor contextualizar as decisões tomadas a respeito do protocolo da camada de Aplicação (PCA). Após esta breve introdução ao aplicativo que terá sua camada implementada como forma de estudo veremos mais profundamente sobre esta  última.
2. Informações gerais
Integrantes: Domarys Corrêa & Gabriella Selbach
Protocolo da camada de transporte: TCP
Arquitetura da aplicação: Servidor – cliente
2. Logic Game
Logic Game é um jogo de perguntas de cunho lógico, disponibilizada em partidas  podendo ter de dois até cinco jogadores que terão um tempo máximo para responder corretamente. Uma partida possui dez rodadas com uma pergunta cada e pode ser escolhidas em diferentes graus de dificuldade como: Fácil, Médio, Difícil e WTF!. A rodada ainda tem um tempo limite de 3 minutos, no qual a pergunta estará disponível para todos os jogadores poderem responder. 
	A pontuação será calculada pela correção da resposta (respostas corretas somam, erradas subtraem), seu tempo para ser respondida (menos tempo maior a quantidade de pontos a somar) e sua dificuldade (Fácil não soma pontuação bônus mas as demais classificações sim). Caso um dos jogadores opte por não responder poderá selecionar a opção “Pular” que terminará esta rodada para ele mas não irá descontar seus pontos. Após o tempo da rodada se encerrar se alguém não responder ou pular haverá uma pequeno desconto também. 
	Ao final da partida a pontuação de todos os participantes é mostrada e após isso os mesmos são encaminhados para a tela principal novamente.
3. Protocolo da camada de aplicação 
O Protocolo da Camada de Aplicação (PCA) trabalhará com a configuração Cliente-servidor e formatos de mensagens simples que possam ser utilizado por ambos os lados sem perda de informações e nem transporte desnecessário de informações.
T1_client: jogador abre o jogo /  manda requisição de conexão para server
T1_serverADD: server manda id thread add && ok
(Primeiro grafo detalha esta parte)

T2_client: jogador acessa pelo botão iniciar na aplicação / client envia “nick” ao servidor
T2_serverADD: recebe o “nick” / linka na lista de jogadores com pontuação zerada && envia ok
T3_client: entrada na tela principal || botão “Atualizar” acionado / solicita atualização de lista de jogadores e jogos disponíveis
T3_serverADD: recebe o pedido da lista atualizada /envia a lista atualizada
T4_client: clica no botão “Entrar” ao lado da partida desejada / envia o id da partida que deseja acessar
T4_serverADD: recebe a solicitação de entrar em uma partida aberta/atualiza tabela de partidas no servidor com o jogador em uma nova entrada && envia ok para o client
T5_client: clica no botão “Novo jogo” / solicita a criação de uma partida (manda dificuldade)
T5_serverADD: recebe solicitação de criação de novo jogo / gera nova partida && atualiza tabela de partidas no servidor com o jogador em uma nova entrada && envia id partida para o client
T7_client: solicita informações da partida
T7_serverADD: recebe a solicitação de informações da partida / envia informações
T8_client: solicita informações da partida
T8_serverADD: recebe a solicitação de informações da partida / envia informações
T10_client: client atualiza var refreshTime / solicita nova atualização da partida  
T10_serverADD: recebe a solicitação de informações da partida / envia informações
T11_client: recebe aviso de inicio 
T11_serverADD: recebe requisição de inicio && verifica demais clients / envia aviso de partida
T13_client: jogador clica botão “Sair” / envia solicitação de saída
T13_serverADD: recebe a solicitação de saída / retira entrada da tabela de partida e coloca na li
T14_client: recebe a resposta / envia pro servidor
T14_serverADD: wait
T15_client: jogador solicita “Pular” / requisição de retirada da partida é enviada
T15_serverADD: wait
T16_client: entrada na tela principal || botão “Atualizar” acionado / solicita atualização de lista de jogadores e jogos disponíveis
T16_serverADD: recebe o pedido da lista atualizada /envia a lista atualizada
T17_client: wait
T17_serverADD: recebe a resposta / verifica correção && envia o resultado
T18_client: finaliza uma rodada && avisa o server
T18_serverADD: recebe confirmação de fim de rodada / atualiza contQuestion 
T19_client: recebe confirmação de nova rodada / solicita pergunta
T19_serverADD: wait
T20_client: finaliza rodada / solicita placar
T20_serverADD: confirma contQuestion  / envia placar  

3.1. Códigos Dot
Códigos Dot estão inclusos para permitir a simulação dos grafos caso as imagens presentes não estejam bem visíveis.
Server (Thread Master):
digraph Server_M {

  Server_on -> e1 [label = "T1"];
  e1 -> e2 [label = "T2"];
  e2 -> e1 [label = "T3"];
  e1 -> Server_off [label = "T4"];

  Server_on [shape=Mdiamond];
  Server_off [shape=Mcircle];
}  
______________________________________________________________________
Server (Thread Add) & Client:
digraph ServerAdd_Client {

  Server_on -> e1 [label = "T1"];
  e1 -> e2 [label = "T2"];
  e2 -> e3 [label = "T3"];
  e2 -> e4 [label = "T4"];
  e2 -> e5 [label = "T5"];
  e3 -> e2 [label = "T6"];
  e4 -> e7 [label = "T7"];
  e5 -> e6 [label = "T8"];
  e6 -> e7 [label = "T9"];
  e7 -> e7 [label = "T10"];
  e7 -> e8 [label = "T11"];  
  e8 -> e9 [label = "T12"];
  e9 -> e10 [label = "T13"];
  e9 -> e11 [label = "T14"];
  e9 -> e12 [label = "T15"];
  e10 -> e2 [label = "T16"];
  e11 -> e12 [label = "T17"];
  e12 -> e12 [label = "T18"];
  e12 -> e9 [label = "T19"];
  e12 -> e13 [label = "T20"];
  e13 -> e10 [label = "T21"];

  e1 -> Server_off [label = "T3"];

  Server_on [shape=Mdiamond];
  Server_off [shape=Mcircle];
}   

3.2. Formato da mensagem:
Tabela vai conter o nome da operação, seu código, descrição.
ID_THREAD – char 8, identificação da thread responsável por este processo; zerada quando tratada pelo protocolo de servidor Master, quando atrelada a uma thread adicional leva o numero dela. (default = “00000000”, antes de ter sido atrelado a uma thread);
ID_CLIENT – char 8, identificação da aplicação presente na máquina do cliente, está em todas as mensagens. (default = “00000000”, antes de ter sido atrelado a uma thread);
ID_GAME: char 4, identificação da partida na tabela de partidas ocorrendo que está no servidor. (“0000” = default; “0281” = partida do João e Roberto);
FLAG _ERROR – após os IDs é a primeira a ser verificada; caso esteja ativa significa erro de comunicação, operação desconhecida, ou mensagem não compreendida. ( “0” = sem erro; com presença de erros fica setada em “1”);
ID_OPERATION – char 3, identifica o tipo de mensagem em requisição (client → server) ou resposta (server → client) com base em uma tabela de identificação presente tanto na aplicação cliente como no servidor. (“000” = default; “001” = CONNECTION_OK);
FLAG_DIFFICULTY: informa dificuldade da partida (“0” = default; “1” = Fácil; “2” = Médio; “3” = Difícil; “4” = WTF);
FLAG_CORRECTION – Informa se a resposta da questão está correta. Não utiliza campo de MSG. (“0” = default; “1” = incorreta; “2” = correta);
FLAG_ANSWER – carrega a repostas do cliente para o servidor (“0” = default; “1” = a; “2” = b; “3” = c; “4” = d; “5” = e);
TIME_STAMP – Informa tempo do client para o server. (“11:52” = exemplo);
MSG – Carrega as strings necessárias para comunicação, por exemplo a pergunta da rodada do servidor para o cliente. (“Pergunta que deverá ser feita aos participantes: xxxxxxxxxxxxxxxxxxxx.” = exemplo);
P.S.: não sabemos  qual o tamanho do campo msg (inicialmente fixamos em 400 chars), pois estamos entre algo muito dispendioso e algo muito restrito em termos de espaço.
3.4. Mensagens 
Mensagens do Server → Client:
→ Server (thread master):
CONNECTION_OK:	 coloca jogador na lista de disponíveis, confirma conexão com o servidor e já envia ID da thread adicional responsável por responder as requisições;
DESCONNECTION_OK: informa retirada do jogador da lista de disponíveis, fecha a conexão e informa ao cliente;
SERVER_FAIL_CONNECTION: falha de comunicação ou conexão;
SERVER_TIMEOUT: se resposta em tempo pré definido;
→ Server (thread adicional):
SERVER_NICK_OK: ao passar da tela de entrada vem para esta parte para informar seu apelido que irá para o servidor;
SERVER_REFRESH_MAIN: solicita listagem atualizada de partidas e jogadores disponíveis;
SERVER_NEWGAME_OK: confirma criação de partida e envia o ID da mesma;
SERVER_LISTGAME_OK: envia lista de jogadores e partidas em andamento;
SERVER_REFRESH_INFO: atualiza informações da sala de espera da partida (jogadores na mesma, tempo de espera, dificuldade);
SERVER_QUESTION_SEND: envia no campo MSG uma mensagem com a dificuldade definida pelo líder da sala;
SERVER_CORRECTION_SEND: informa o status da resposta enviada do cliente (0 =  default; 1 = errada; 2 = certa);
SERVER_JUMP_OK: informa que o pedido de “Pular” do client foi registrado;
SERVER_FINISHGAME_OK: informa fim da partida correto;
SERVER_SCORE: manda dados da pontuação;
SERVER_EXIT_OK: servidor sinaliza fim da conexão. 

Mensagens Client → Server:
REQUEST_NICK: coleta apelido na tela de entrada e envia ao servidor para cadastro em suas listas;
REQUEST_REFRESH: atulização das informações da tela principal;
REQUEST_NEWGAME: solicita novo jogo passando a dificuldade;
REQUEST_INGAME: solicita acesso à sala de espera de uma partida que está para começar;
REQUEST_INFOGAME: solicita informações da sala de espera da partida;
REQUEST_QUESTION: solicita uma nova pergunta ao servidor, passando a dificuldade;
REQUEST_CORRECTION: pede a correção.
REQUEST_PUSH: jogador solicita “Pular”;
REQUEST_FINISHGAME: solicita fim da partida;
REQUEST_SCORE: pede as informações do servidor em relação à pontuação da partida;
REQUEST_EXIT: solicita saída do jogo;
