CREATE TABLE IF NOT EXISTS cocktails (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    alcoholic VARCHAR(50),
    glass VARCHAR(100),
    instructions TEXT,
    image_url TEXT
);

INSERT INTO cocktails (name, category, alcoholic, glass, instructions, image_url) VALUES
('Margarita', 'Cocktail', 'Alcoholic', 'Cocktail glass', 'Shake and strain into a chilled cocktail glass.', 'https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg'),
('Mojito', 'Cocktail', 'Alcoholic', 'Highball glass', 'Muddle mint leaves with sugar and lime juice. Add rum and top with soda water.', 'https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg'),
('Piña Colada', 'Cocktail', 'Alcoholic', 'Hurricane glass', 'Blend all ingredients with ice until smooth.', 'https://www.thecocktaildb.com/images/media/drink/cpf4j51504371346.jpg');