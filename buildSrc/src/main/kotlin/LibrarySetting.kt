import ProjectSetting.APP_DOMAIN
import ProjectSetting.APP_PLAY_CONSOLE

/**
 * Created by faisalamir on 19/09/21
 *
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

object LibrarySetting {

    const val GITHUB_ACCOUNT = "amirisback"
    const val GITHUB_REPOSITORY = "frogo-recycler-view"

    const val LIB_NAME = "recycler"

    const val ARTIFACT_ID = GITHUB_REPOSITORY
    const val GROUP_ID = "com.github.$GITHUB_ACCOUNT"

    const val NAME_SPACE = "$APP_DOMAIN.$APP_PLAY_CONSOLE.$LIB_NAME"

    const val MAVEN_URI = "https://maven.pkg.github.com/$GITHUB_ACCOUNT/$GITHUB_REPOSITORY"

}