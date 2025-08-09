Feature: Criando receita
  Como um usuário do sistema
  Eu quero criar uma receita
  Para consultar quando necessário

Scenario: Criando um receita
  Given que estou a criar uma receita
  And informo o nome do receita "Bolo de Milho"
  And informo a descricao da receita "Descrição X"
  When envio os dados da receita
  Then a receita deve ser criada

Scenario: Avaliando com estrelas
  Given que estou a criar uma receita
  And informo o nome do receita "Pastel de Carne"
  And informo a descricao da receita "Descrição X"
  And classifico com estrelas 5
  When envio os dados da receita
  Then a classificacao deve ser salva