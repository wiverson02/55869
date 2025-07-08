# 🚀 Guia Completo: Implementar API de Geração de Imagens

## ✅ Status Atual
- ✅ Botão "Gerar Imagens IA" implementado
- ✅ Modal de configuração criado
- ✅ Função de API real implementada
- ✅ Arquivo de configuração criado
- ⏳ **Falta apenas configurar sua chave de API**

---

## 📋 Passo a Passo Detalhado

### **PASSO 1: Obter Chave da API OpenAI**

1. **Acesse:** https://platform.openai.com/
2. **Faça login** ou crie uma conta
3. **Vá em "API Keys"** no menu lateral
4. **Clique em "Create new secret key"**
5. **Dê um nome** (ex: "Site Carros")
6. **Copie a chave** (começa com `sk-`)
7. **Guarde a chave** em local seguro

### **PASSO 2: Configurar a Chave**

1. **Abra o arquivo `config.js`**
2. **Substitua a linha:**
   ```javascript
   OPENAI: 'sk-sua_chave_openai_aqui',
   ```
   **Por:**
   ```javascript
   OPENAI: 'sk-abc123def456...', // sua chave real aqui
   ```

### **PASSO 3: Testar a Funcionalidade**

1. **Abra o arquivo `index.html`** no navegador
2. **Role para baixo** até "Novas Funcionalidades"
3. **Clique em "Gerar Imagens IA"**
4. **Selecione um carro** (ex: Toyota Corolla)
5. **Escolha um estilo** (ex: Estilo Catálogo)
6. **Clique em "Gerar Imagem 1"**
7. **Aguarde** (pode demorar 10-30 segundos)
8. **Veja a imagem real** gerada pela IA!

---

## 🔧 Configurações Avançadas

### **Alterar Qualidade da Imagem**

No arquivo `config.js`, você pode alterar:

```javascript
const API_CONFIG = {
    OPENAI: {
        model: 'dall-e-3',        // Modelo (dall-e-2 ou dall-e-3)
        size: '1024x1024',        // Tamanho (256x256, 512x512, 1024x1024)
        quality: 'standard',      // Qualidade (standard ou hd)
        n: 1                      // Número de imagens
    }
};
```

### **Custos Estimados**

- **DALL-E 3 Standard:** $0.04 por imagem
- **DALL-E 3 HD:** $0.08 por imagem
- **DALL-E 2:** $0.02 por imagem

---

## 🛠️ Solução de Problemas

### **Erro: "Chave da API não configurada"**
- ✅ Verifique se editou o arquivo `config.js`
- ✅ Confirme que a chave começa com `sk-`
- ✅ Recarregue a página

### **Erro: "Insufficient credits"**
- 💳 Adicione créditos na sua conta OpenAI
- 💳 Vá em "Billing" no painel da OpenAI

### **Erro: "Rate limit exceeded"**
- ⏰ Aguarde alguns minutos
- ⏰ Reduza o número de requisições

### **Imagens não aparecem**
- 🔄 Verifique a conexão com internet
- 🔄 Abra o Console do navegador (F12) para ver erros
- 🔄 Tente gerar novamente

---

## 🎯 Exemplos de Prompts Efetivos

### **Toyota Corolla:**
```
"Toyota Corolla 2015, cor prata, estilo foto de catálogo, fundo branco, ângulo lateral, realista, alta qualidade, 4K, detalhes nítidos"
```

### **Honda Civic:**
```
"Honda Civic 2015, cor branca, estúdio fotográfico profissional, iluminação dramática, ângulo 3/4, realista, premium"
```

### **Hyundai Azera:**
```
"Hyundai Azera 2015, cor preta, estilo luxo, fundo elegante, iluminação sofisticada, realista, carro executivo"
```

---

## 🚀 Funcionalidades Extras

### **Download de Imagens**
- ✅ Botão "⬇️ Download" aparece automaticamente
- ✅ Salva a imagem no seu computador
- ✅ Nome único com timestamp

### **Aplicar aos Cards**
- ✅ Clique em "Usar Imagem"
- ✅ A imagem é aplicada ao card do carro
- ✅ Atualização automática na página

### **Prompts Personalizados**
- ✅ Campo para escrever seu próprio prompt
- ✅ Deixe em branco para usar o padrão
- ✅ Total liberdade de criação

---

## 📞 Suporte

### **Se algo não funcionar:**

1. **Verifique o Console** (F12 → Console)
2. **Confirme a chave da API** está correta
3. **Teste com prompt simples** primeiro
4. **Verifique sua conexão** com internet

### **Links Úteis:**
- 📖 [Documentação OpenAI](https://platform.openai.com/docs/api-reference/images)
- 💳 [Adicionar Créditos](https://platform.openai.com/account/billing)
- 🔑 [Gerenciar Chaves](https://platform.openai.com/api-keys)

---

## 🎉 Pronto!

Agora você tem um **gerador de imagens com IA real** no seu site! 

**Teste agora:**
1. Configure sua chave no `config.js`
2. Abra o `index.html`
3. Clique em "Gerar Imagens IA"
4. Divirta-se criando imagens únicas! 🚗✨ 