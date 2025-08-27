function validarFormularioPedido() {
  const nome = document.getElementById('nome').value.trim();
  const produto = document.getElementById('produto').value;
  const quantidade = document.getElementById('quantidade').value;

  if (nome === '') {
    alert('Por favor, preencha seu nome.');
    return false;
  }
  if (produto === '') {
    alert('Por favor, selecione um produto.');
    return false;
  }
  if (quantidade === '' || quantidade <= 0) {
    alert('Informe uma quantidade válida.');
    return false;
  }
  alert('Pedido enviado com sucesso!');
  return true;
}

function validarFormularioContato() {
  const nome = document.getElementById('nome').value.trim();
  const email = document.getElementById('email').value.trim();
  const mensagem = document.getElementById('mensagem').value.trim();

  if (nome === '') {
    alert('Por favor, preencha seu nome.');
    return false;
  }
  if (email === '') {
    alert('Por favor, preencha seu e-mail.');
    return false;
  }
  // Simples validação de email
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    alert('Por favor, informe um e-mail válido.');
    return false;
  }
  if (mensagem === '') {
    alert('Por favor, escreva sua mensagem.');
    return false;
  }
  alert('Mensagem enviada com sucesso!');
  return true;
}
