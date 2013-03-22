package org.powershell.editors;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.powershell.editors.outline.PowershellContentOutline;
import org.powershell.editors.partition.PowershellDocumentProvider;

/**
 * The Class PowershellEditor.
 * 
 * @author dalexandrov
 */
public class PowershellEditor extends TextEditor {

	public final static String EDITOR_MATCHING_BRACKETS = "matchingBrackets";
	public final static String EDITOR_MATCHING_BRACKETS_COLOR = "matchingBracketsColor";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#initializeEditor()
	 */
	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setSourceViewerConfiguration(new PowershellEditorConfiguration());
	}

	/**
	 * Instantiates a new powershell editor.
	 */
	public PowershellEditor() {
		super();
		setSourceViewerConfiguration(new PowershellEditorConfiguration());
		setDocumentProvider(new PowershellDocumentProvider());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void configureSourceViewerDecorationSupport(
			SourceViewerDecorationSupport support) {
		super.configureSourceViewerDecorationSupport(support);

		char[] matchChars = { '(', ')', '[', ']', '{', '}' }; // which brackets
																// to match
		ICharacterPairMatcher matcher = new DefaultCharacterPairMatcher(
				matchChars, IDocumentExtension3.DEFAULT_PARTITIONING);
		support.setCharacterPairMatcher(matcher);
		support.setMatchingCharacterPainterPreferenceKeys(
				EDITOR_MATCHING_BRACKETS, EDITOR_MATCHING_BRACKETS_COLOR);

		// Enable bracket highlighting in the preference store
		IPreferenceStore store = getPreferenceStore();
		store.setDefault(EDITOR_MATCHING_BRACKETS, true);
		store.setDefault(EDITOR_MATCHING_BRACKETS_COLOR, "128,128,128");
	}

	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IContentOutlinePage.class)) {

			return getContentOutlinePage();

		} else {
			return super.getAdapter(key);
		}
	}

	public IContentOutlinePage getContentOutlinePage() {
		return PowershellContentOutline.INSTANCE;
	}
}
