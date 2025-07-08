# Integração com APIs de IA para Geração de Imagens

## Funcionalidade Implementada

O site agora possui um **Gerador de Imagens com IA** que permite:

- ✅ Selecionar qualquer carro do catálogo
- ✅ Escolher entre 5 estilos diferentes de imagem
- ✅ Personalizar prompts de geração
- ✅ Gerar 3 variações de imagem simultaneamente
- ✅ Aplicar as imagens geradas aos cards dos carros
- ✅ Interface intuitiva e responsiva

## Como Funciona Atualmente

A funcionalidade está **simulada** e mostra:
- Loading spinner durante a "geração"
- Imagens placeholder com o prompt usado
- Botões para aplicar as imagens aos cards

## Integração com APIs Reais

### 1. OpenAI DALL-E 3 (Recomendado)

```javascript
// Substitua a função generateImageWithAI por:
async function generateImageWithAI(prompt, imageContainerId) {
    const container = document.getElementById(imageContainerId);
    container.innerHTML = '<div class="flex items-center justify-center h-full"><div class="animate-spin rounded-full h-8 w-8 border-b-2 border-pink-500"></div></div>';
    
    try {
        const response = await fetch('https://api.openai.com/v1/images/generations', {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${YOUR_OPENAI_API_KEY}`,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                model: "dall-e-3",
                prompt: prompt,
                n: 1,
                size: "1024x1024",
                quality: "standard"
            })
        });
        
        const data = await response.json();
        const imageUrl = data.data[0].url;
        
        container.innerHTML = `<img src="${imageUrl}" alt="Imagem gerada com IA" class="w-full h-full object-cover rounded-lg">`;
    } catch (error) {
        container.innerHTML = '<div class="text-red-500 text-center">Erro ao gerar imagem</div>';
        console.error('Erro:', error);
    }
}
```

### 2. Midjourney (via API)

```javascript
// Para Midjourney, você precisará de um serviço intermediário
async function generateImageWithMidjourney(prompt, imageContainerId) {
    const container = document.getElementById(imageContainerId);
    container.innerHTML = '<div class="flex items-center justify-center h-full"><div class="animate-spin rounded-full h-8 w-8 border-b-2 border-pink-500"></div></div>';
    
    try {
        const response = await fetch('https://api.midjourney.com/v1/imagine', {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${YOUR_MIDJOURNEY_API_KEY}`,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                prompt: prompt,
                width: 1024,
                height: 1024
            })
        });
        
        const data = await response.json();
        const imageUrl = data.imageUrl;
        
        container.innerHTML = `<img src="${imageUrl}" alt="Imagem gerada com IA" class="w-full h-full object-cover rounded-lg">`;
    } catch (error) {
        container.innerHTML = '<div class="text-red-500 text-center">Erro ao gerar imagem</div>';
        console.error('Erro:', error);
    }
}
```

### 3. Stable Diffusion (via API)

```javascript
// Para Stable Diffusion
async function generateImageWithStableDiffusion(prompt, imageContainerId) {
    const container = document.getElementById(imageContainerId);
    container.innerHTML = '<div class="flex items-center justify-center h-full"><div class="animate-spin rounded-full h-8 w-8 border-b-2 border-pink-500"></div></div>';
    
    try {
        const response = await fetch('https://api.stability.ai/v1/generation/stable-diffusion-xl-1024-v1-0/text-to-image', {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${YOUR_STABILITY_API_KEY}`,
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                text_prompts: [
                    {
                        text: prompt,
                        weight: 1
                    }
                ],
                cfg_scale: 7,
                height: 1024,
                width: 1024,
                samples: 1,
                steps: 30
            })
        });
        
        const data = await response.json();
        const imageUrl = `data:image/png;base64,${data.artifacts[0].base64}`;
        
        container.innerHTML = `<img src="${imageUrl}" alt="Imagem gerada com IA" class="w-full h-full object-cover rounded-lg">`;
    } catch (error) {
        container.innerHTML = '<div class="text-red-500 text-center">Erro ao gerar imagem</div>';
        console.error('Erro:', error);
    }
}
```

## Configuração de Chaves de API

### 1. Criar arquivo de configuração

Crie um arquivo `config.js`:

```javascript
const API_KEYS = {
    OPENAI: 'sua_chave_openai_aqui',
    MIDJOURNEY: 'sua_chave_midjourney_aqui',
    STABILITY: 'sua_chave_stability_aqui'
};
```

### 2. Incluir no HTML

```html
<script src="config.js"></script>
```

### 3. Usar no código

```javascript
const YOUR_OPENAI_API_KEY = API_KEYS.OPENAI;
```

## Prompts Otimizados

Os prompts já estão otimizados para cada carro e estilo:

### Exemplos de Prompts Efetivos:

**Toyota Corolla:**
- "Toyota Corolla 2015, cor prata, estilo foto de catálogo, fundo branco, ângulo lateral, realista, alta qualidade, 4K"

**Honda Civic:**
- "Honda Civic 2015, cor branca, estúdio fotográfico profissional, iluminação dramática, ângulo 3/4, realista, detalhes nítidos"

**Hyundai Azera:**
- "Hyundai Azera 2015, cor preta, estilo luxo, fundo elegante, iluminação sofisticada, realista, premium"

## Dicas para Melhores Resultados

1. **Seja Específico:** Inclua ano, cor, ângulo e estilo
2. **Use Palavras-Chave:** "realista", "alta qualidade", "4K", "profissional"
3. **Evite Ambiguidade:** Não use termos vagos como "bonito" ou "legal"
4. **Teste Diferentes Estilos:** Cada API responde melhor a diferentes abordagens
5. **Ajuste Prompts:** Baseado nos resultados, refine os prompts

## Custos Estimados

- **DALL-E 3:** ~$0.04 por imagem (1024x1024)
- **Midjourney:** ~$0.10 por imagem
- **Stable Diffusion:** ~$0.02 por imagem

## Próximos Passos

1. Escolha uma API de IA
2. Obtenha sua chave de API
3. Substitua a função `generateImageWithAI` pela versão real
4. Teste com diferentes prompts
5. Ajuste os prompts baseado nos resultados

## Suporte

Para dúvidas sobre integração ou otimização de prompts, consulte a documentação da API escolhida ou entre em contato. 