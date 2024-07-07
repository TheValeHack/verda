package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Main.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import util.Session;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import Models.KelasBelajar;
import Models.KelasQuiz;
import Models.KelasVideo;
import Models.Langganan;
import Models.Pengguna;

public class KelasBelajarController {

    @FXML
    private VBox vboxdaftarmateri;

    private KelasBelajar kelasBelajar;
    private ArrayList<KelasVideo> kelasMateri;
    private ArrayList<KelasQuiz> kelasQuiz;

    public void initData(KelasBelajar kelasBelajar) {
    	this.kelasBelajar = kelasBelajar;
        kelasMateri = kelasBelajar.getVideos();
        kelasQuiz = kelasBelajar.getQuizzes();
        Pengguna currentUser = Session.getUser();
    	Langganan userLangganan = currentUser.getLangganan();

        ArrayList<Object> combinedList = new ArrayList<>();
        combinedList.addAll(kelasMateri);
        combinedList.addAll(kelasQuiz);

        Collections.sort(combinedList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof KelasVideo && o2 instanceof KelasQuiz) {
                    return ((KelasVideo) o1).getOrderVideo() - ((KelasQuiz) o2).getOrderQuiz();
                } else if (o1 instanceof KelasQuiz && o2 instanceof KelasVideo) {
                    return ((KelasQuiz) o1).getOrderQuiz() - ((KelasVideo) o2).getOrderVideo();
                } else if (o1 instanceof KelasVideo && o2 instanceof KelasVideo) {
                    return ((KelasVideo) o1).getOrderVideo() - ((KelasVideo) o2).getOrderVideo();
                } else {
                    return ((KelasQuiz) o1).getOrderQuiz() - ((KelasQuiz) o2).getOrderQuiz();
                }
            }
        });

        for (Object item : combinedList) {
            try {
                HBox hbox;
                if (item instanceof KelasVideo) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/MateriItem.fxml"));
                    hbox = loader.load();
                    MateriItemController controller = loader.getController();
                    controller.setData((KelasVideo) item);
                    
                    int order = (item instanceof KelasVideo) ? ((KelasVideo) item).getOrderVideo() : ((KelasQuiz) item).getOrderQuiz();
                    if(userLangganan == null) {
                    	if(order < 2) {
                    		hbox.setOnMouseClicked(event -> handleOpenVideo((KelasVideo) item));
                    	}
                    } else {
                    	hbox.setOnMouseClicked(event -> handleOpenVideo((KelasVideo) item));
                    }
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/KuisItem.fxml"));
                    hbox = loader.load();
                    KuisItemController controller = loader.getController();
                    controller.setData((KelasQuiz) item);
                    int order = (item instanceof KelasVideo) ? ((KelasVideo) item).getOrderVideo() : ((KelasQuiz) item).getOrderQuiz();
                    if(userLangganan == null) {
                    	if(order < 2) {
                    		hbox.setOnMouseClicked(event -> handleOpenQuiz((KelasQuiz) item));
                    	}
                    } else {
                    	hbox.setOnMouseClicked(event -> handleOpenQuiz((KelasQuiz) item));
                    }
                }
                
                int order = (item instanceof KelasVideo) ? ((KelasVideo) item).getOrderVideo() : ((KelasQuiz) item).getOrderQuiz();
                if(userLangganan == null) {
                	if (order > 1) {
                        Pane overlay = new Pane();
                        overlay.getStyleClass().add("overlay");
                        hbox.getChildren().add(overlay);
                        hbox.getStyleClass().add("disable-click");
                    }
                }
                
                vboxdaftarmateri.getChildren().add(hbox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void handleBackButtonClick(MouseEvent event) throws Exception {
        App.showPelatihanView();
    }
    private void handleOpenVideo(KelasVideo video) {
    	try {
			App.showPlayVideoView(kelasBelajar, video);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void handleOpenQuiz(KelasQuiz quiz) {
    	try {
			App.showPlayQuizView(kelasBelajar, quiz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
