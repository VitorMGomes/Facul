# Gerador de PDF

# Sumário

- [Gerador de PDF](#gerador-de-pdf)
- [Sumário](#sumário)
  - [Instalação](#instalação)
  - [Código da aplicação](#código-da-aplicação)
  - [Resultado](#resultado)

## Instalação

Para inicializar o programa para teste, é necessário instalar os pré-requisitos contidos no `package.json`. Para instalá-los, basta abrir o terminal na pasta do arquivo e executar:

```bash
npm install
```

> No shell é nessesario estar no diretorio do projeto

> [!IMPORTANT]
> Lembre-se de ja ter feito as intruções contidas no [README](../README.md) principal

## Código da aplicação

O objetivo deste programa é acessar um formulário do Google, preenchê-lo e enviar a resposta.

O preenchimento é feito por meio da função `page.locator().fill()`

```js

const puppeteer = require('puppeteer');

async function preencherInput() {
    const browser = await puppeteer.launch({ timeout: 1000, headless: "new" });
    const page = await browser.newPage();
    for (let i = 0; i < 500; i++) {
        console.log("carregando... " + i)
        await page.goto('https://forms.gle/xEBpuUZknuxFMY8T7', { waitUntil: ['networkidle0', 'domcontentloaded'], timeout: 0 });
        await page.locator("#mG61Hd > div.RH5hzf.RLS9Fe > div > div.o3Dpx > div > div > div > div.AgroKb > div > div.aCsJod.oJeWuf > div > div.Xb9hP > input").fill('ola funcionou');
        const element = await page.waitForSelector('#mG61Hd > div.RH5hzf.RLS9Fe > div > div.ThHDze > div.DE3NNc.CekdCb > div.lRwqcd > div > span > span');
        await element.click();
        await page.waitForTimeout(2000);
    }
    await browser.close();
}
preencherInput();

```

## Resultado

A pagina vai para a url do forms

![1713977912948](image/README/1713977912948.png)

Preenchera o input

![1713964955536](image/README/1713964955536.png)

E enviara o formulario

> [!IMPORTANT]
> O formulário não pode requerer login.
