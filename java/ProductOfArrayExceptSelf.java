import nltk
from nltk.tokenize import word_tokenize

# Download 'punkt' tokenizer data if not already done
nltk.download('punkt')

text = "Tokenization without transformers is straightforward with tools like NLTK."
tokens_nltk = word_tokenize(text)
print("Tokens (NLTK):", tokens_nltk)

from transformers import AutoTokenizer
import torch

tokenizer = AutoTokenizer.from_pretrained("bert-base-uncased")
tokens_transformers = tokenizer(text, return_tensors="pt")
print("Transformers Tokens (input_ids):", tokens_transformers['input_ids'])

# Convert input_ids to tokens
tokens_transformers_list = tokenizer.convert_ids_to_tokens(tokens_transformers['input_ids'][0].tolist())
print("Transformers Tokens (List):", tokens_transformers_list)

# Decode back to text (skip special tokens)
decoded_text = tokenizer.decode(tokens_transformers['input_ids'], skip_special_tokens=True)
print("Decoded Text:", decoded_text)

