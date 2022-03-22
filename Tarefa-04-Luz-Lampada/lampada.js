document.getElementById('lampada').addEventListener("click", function (){
    var imagem = document.getElementById('lampada').src;
    var lampDesligada = "https://i.stack.imgur.com/b983w.jpg";
    var lampLigada = "https://i.stack.imgur.com/ybxlO.jpg";
    
    if(imagem === lampLigada){
      document.getElementById('lampada').src = lampDesligada;
    } else {
      document.getElementById('lampada').src = lampLigada;
    }
  })
