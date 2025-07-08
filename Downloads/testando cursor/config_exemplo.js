// EXEMPLO: Como deve ficar seu arquivo config.js
// COPIE este conteúdo e renomeie para config.js
// SUBSTITUA 'sk-sua_chave_aqui' pela sua chave real do OpenAI

const API_KEYS = {
    // ✅ SUBSTITUA ESTA LINHA pela sua chave real
    OPENAI: 'sk-sua_chave_aqui',
    
    // Outras APIs (opcional - deixe como está)
    MIDJOURNEY: 'sua_chave_midjourney_aqui',
    STABILITY: 'sua_chave_stability_aqui'
};

// Configurações da API (pode deixar como está)
const API_CONFIG = {
    OPENAI: {
        model: 'dall-e-3',
        size: '1024x1024',
        quality: 'standard',
        n: 1
    }
};

// EXEMPLO de como deve ficar com chave real:
/*
const API_KEYS = {
    OPENAI: 'sk-abc123def456ghi789jkl012mno345pqr678stu901vwx234yz567',
    MIDJOURNEY: 'sua_chave_midjourney_aqui',
    STABILITY: 'sua_chave_stability_aqui'
};
*/ 