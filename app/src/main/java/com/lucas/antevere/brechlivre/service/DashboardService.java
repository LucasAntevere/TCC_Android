package com.lucas.antevere.brechlivre.service;

import com.lucas.antevere.brechlivre.contracts.Carrousel;
import com.lucas.antevere.brechlivre.contracts.Category;
import com.lucas.antevere.brechlivre.contracts.Dashboard;
import com.lucas.antevere.brechlivre.contracts.FeaturedCard;
import com.lucas.antevere.brechlivre.contracts.Product;

import java.util.ArrayList;
import java.util.List;

public class DashboardService {
    private String DASHBOARD_GET_CACHE_TAG = "DASHBOARD_GET_CACHE";

    public Dashboard Get(){
        Dashboard dash = new Dashboard();

        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Harry Potter e a Criança Amaldiçoada", "Livros", "http://ecx.images-amazon.com/images/I/51jNORv6nQL._AC_UL320_SR218,320_.jpg"));
        products.add(new Product("2", "Jogos Vorazes", "Livros", "http://vignette4.wikia.nocookie.net/thehungergames/images/b/b8/Hungergames_poster.jpg/revision/latest?cb=20120329195535"));
        products.add(new Product("3", "O Cemitério", "Livros", "http://lelivros.website/wp-content/uploads/2013/09/Download-livro-O-Cemiterio-Stephen-King-em-ePUB-mobi-e-PDF.jpg"));
        products.add(new Product("4", "A Coisa", "Livros", "http://media.brainz.org/uploads/2010/03/stephen-king/misery.jpg"));
        products.add(new Product("5", "Carrie", "Livros", "http://d.gr-assets.com/books/1166254258l/10592.jpg"));
        products.add(new Product("6", "Donnie Darko", "Livros", "http://www.cantodosclassicos.com/wp-content/uploads/2015/05/donnie-darko-cd.jpg"));

        dash.getCarrousels().add(new Carrousel("Livros imperdíveis", "Novo e usados", products));
        dash.getCarrousels().add(new Carrousel("Filmes", "Fim de semana cinéfilo", products));
        dash.getCarrousels().add(new Carrousel("Instrumentos", "Monte sua banda", products));
        dash.getCarrousels().add(new Carrousel("Veículos", "De bicicletas à navios", products));
        dash.getCarrousels().add(new Carrousel("Vestiário", "Para não perder o estilo", products));
        dash.getCarrousels().add(new Carrousel("Carros", "Pegue o último module", products));
        dash.getCarrousels().add(new Carrousel("Informática", "Nunca fique desconectado", products));
        dash.getCarrousels().add(new Carrousel("Agasalhos", "O frio está vindo, é melhor se preparar", products));

        dash.getCategories().add(new Category(1, "Livros", "#aa0000", "ic_menu_camera"));
        dash.getCategories().add(new Category(1, "Vestiário", "#d45500", "ic_menu_send"));
        dash.getCategories().add(new Category(1, "Móveis", "#6c5353", "ic_menu_share"));
        dash.getCategories().add(new Category(1, "Eletrônicos", "#003380", "ic_menu_gallery"));
        dash.getCategories().add(new Category(1, "Animais", "#217821", "ic_menu_slideshow"));
        dash.getCategories().add(new Category(1, "Instrumentos", "#0088aa", "ic_audiotrack_24dp"));
        dash.getCategories().add(new Category(1, "Veículos", "#536c5d", "ic_settings_24dp"));
        dash.getCategories().add(new Category(1, "Veículos", "#536c5d", "ic_settings_24dp"));
        dash.getCategories().add(new Category(1, "Veículos", "#536c5d", "ic_settings_24dp"));
        dash.getCategories().add(new Category(1, "Veículos", "#536c5d", "ic_settings_24dp"));

        dash.getFeaturedCards().add(new FeaturedCard("Presenteie no Natal", "Aproveite o clima natalino e ajude o próximo.", "http://pradorevista.com.br/wp-content/uploads/2015/12/Feliz-Natal-12.jpg"));

        return dash;
    }
}
