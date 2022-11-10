package com.itmo.myplugin

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.ui.Messages
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class TwitterAction(): AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        val editor = event.getData(PlatformDataKeys.EDITOR)
        val text = editor?.selectionModel?.selectedText

        val encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8.toString())

        val url = String.format("https://twitter.com/intent/tweet?text=%s", encodedText)

        Messages.showMessageDialog(url, "Telega Action", Messages.getInformationIcon())

        BrowserUtil.browse(url)
    }
}