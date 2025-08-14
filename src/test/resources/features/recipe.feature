Feature: Criando receita
  Como um usuário do sistema
  Eu quero criar uma receita
  Para consultar quando necessário

Scenario: Criando uma receita
  Given que estou a criar uma receita
  And informo o nome do receita "Bolo de Milho"
  And informo a descricao da receita "Descrição X"
  When envio os dados da receita
  Then a receita deve ser criada

Scenario Outline: Criando varias receitas
  Given que estou a criar varias receitas
  And informo o nome do receita '<name>'
  And informo a descricao da receita '<desc>'
  And adiciono a receita na lista
  When envio a lista com os dados da receita
  Then as receitas devem ser criadas '<name>'

Examples:
  |name             |desc           |
  |Picanha invertida|Serve 3 pessoas|
  |Pao de Alho      |Serve 4 pessoas|

Scenario: Avaliando com estrelas
  Given que estou a criar uma receita
  And informo o nome do receita "Pastel de Carne"
  And informo a descricao da receita "Descrição X"
  And classifico com estrelas 5
  When envio os dados da receita
  Then a classificacao deve ser salva