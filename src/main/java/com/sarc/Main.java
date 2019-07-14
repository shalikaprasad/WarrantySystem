package com.sarc;

import com.sarc.config.StageManager;
import com.sarc.controller.PreloaderController;
import com.sarc.view.FxmlView;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {

	protected ConfigurableApplicationContext springContext;
	protected StageManager stageManager;
	private static final int COUNT_LIMIT = 4;

	public static void main(final String[] args) {
		LauncherImpl.launchApplication(Main.class, PreloaderController.class, args);
	}

	@Override
	public void init() throws Exception {

		for (int i = 1; i <= COUNT_LIMIT; i++) {
			double progress = (double) i / 10;
			System.out.println("progress: " + progress);
			LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
			Thread.sleep(2000);
		}
		springContext = springBootApplicationContext();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stageManager = springContext.getBean(StageManager.class, stage);
		displayInitialScene();
	}

	@Override
	public void stop() throws Exception {
		springContext.close();
	}

	/**
	 * Useful to override this method by sub-classes wishing to change the first
	 * Scene to be displayed on startup. Example: Functional tests on main
	 * window.
	 */
	protected void displayInitialScene() {
		stageManager.switchScene(FxmlView.LOGIN);
	}

	private ConfigurableApplicationContext springBootApplicationContext() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		return builder.run(args);
	}

}
